/*
 * Copyright 2015 lifetime.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package old.ui.helper;

import old.util.ServiceLocator;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamVariable;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Html5File;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author lifetime
 */
public class ImageDropBox extends DragAndDropWrapper implements
        DropHandler {

    private static final long FILE_SIZE_LIMIT = 2 * 1024 * 1024; // 2MB
    //private ProgressBar progress;
    private final ProgressBar progress;
    private final Integer userId;
    private final Layout rootLayout;

    public ImageDropBox(Integer userId, final Layout root) {
        super(root);
        setDropHandler(this);
        this.userId = userId;
        rootLayout = root;
        progress = new ProgressBar();
        progress.setIndeterminate(true);
        progress.setVisible(false);
        root.addComponent(progress);
    }

    @Override
    public void drop(final DragAndDropEvent dropEvent) {

        // expecting this to be an html5 drag
        Notification
                .show("Drop Event...",
                        Notification.Type.WARNING_MESSAGE);
        final DragAndDropWrapper.WrapperTransferable tr = (DragAndDropWrapper.WrapperTransferable) dropEvent
                .getTransferable();
        final Html5File[] files = tr.getFiles();
        if (files != null) {
            for (final Html5File html5File : files) {
                final String fileName = html5File.getFileName();

                if (html5File.getFileSize() > FILE_SIZE_LIMIT) {
                    Notification
                            .show("File rejected. Max 2Mb files are accepted by Sampler",
                                    Notification.Type.WARNING_MESSAGE);
                } else {

                    final ByteArrayOutputStream bas = new ByteArrayOutputStream();
                    final StreamVariable streamVariable = new StreamVariable() {

                        @Override
                        public OutputStream getOutputStream() {
                            return bas;
                        }

                        @Override
                        public boolean listenProgress() {
                            return false;
                        }

                        @Override
                        public void onProgress(
                                final StreamVariable.StreamingProgressEvent event) {
                        }

                        @Override
                        public void streamingStarted(
                                final StreamVariable.StreamingStartEvent event) {
                        }

                        @Override
                        public void streamingFinished(
                                final StreamVariable.StreamingEndEvent event) {
                            storeImageInDB(bas.toByteArray());
                            showFile(fileName, html5File.getType(), bas);
                            progress.setVisible(false);
                        }

                        @Override
                        public void streamingFailed(
                                final StreamVariable.StreamingErrorEvent event) {
                            progress.setVisible(false);
                        }

                        @Override
                        public boolean isInterrupted() {
                            return false;
                        }

                        private void storeImageInDB(byte[] bytes) {
                            Notification
                                    .show("Storing in DB",
                                            Notification.Type.WARNING_MESSAGE);
                            ServiceLocator.findLifetimeService().addUserPhoto(userId, bytes);
                        }

                    };
                    html5File.setStreamVariable(streamVariable);
                    progress.setVisible(true);
                }
            }

        } else {
            final String text = tr.getText();
            if (text != null) {
                showText(text);
            }
        }
    }

    private void showText(final String text) {
        showComponent(new Label(text), "Wrapped text content");
    }

    private void showFile(final String name, final String type,
            final ByteArrayOutputStream bas) {
        // resource for serving the file contents
        final StreamResource.StreamSource streamSource = new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                if (bas != null) {
                    final byte[] byteArray = bas.toByteArray();
                    return new ByteArrayInputStream(byteArray);
                }
                return null;
            }
        };
        final StreamResource resource = new StreamResource(streamSource,
                name);

        // show the file contents - images only for now
        final Embedded embedded = new Embedded("", resource);
        showComponent(embedded, name);
    }

    private void showComponent(final Component c, final String name) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeUndefined();
        layout.setMargin(true);
        final Window w = new Window(name, layout);
        w.addStyleName("dropdisplaywindow");
        w.setSizeUndefined();
        w.setResizable(false);
        c.setSizeUndefined();
        layout.addComponent(c);
        UI.getCurrent().addWindow(w);

    }

    private void showComponent2(final Component c, final String name) {
        ((ComponentContainer) getCompositionRoot()).removeAllComponents();
        ((ComponentContainer) getCompositionRoot()).addComponent(c);
        //c.setSizeFull();
    }

    @Override
    public AcceptCriterion getAcceptCriterion() {
        return AcceptAll.get();
    }
}
