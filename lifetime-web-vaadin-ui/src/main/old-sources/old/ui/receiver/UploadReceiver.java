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
package old.ui.receiver;

import com.vaadin.ui.Upload;
import com.vaadin.ui.Window;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 *
 * @author lifetime
 */
public abstract class UploadReceiver implements Upload.Receiver, Upload.SucceededListener {

    private final Integer userId;
    private ByteArrayOutputStream baos;
    private Window window;
    private final String language;

    public UploadReceiver(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        baos = new ByteArrayOutputStream(1024);
        baos.reset();
        return baos;
    }
    
    public void setWindow(Window window) {
        this.window = window;
    }


    public ByteArrayOutputStream getBaos() {
        return baos;
    }

    public Integer getUserId() {
        return userId;
    }

    public Window getWindow() {
        return window;
    }

    public String getLanguage() {
        return language;
    }
    
    
}
