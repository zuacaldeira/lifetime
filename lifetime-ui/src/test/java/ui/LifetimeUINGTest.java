/*
 * Copyright 2015 zua.
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
package ui;

import com.vaadin.server.VaadinRequest;
import lifetime.persistence.exceptions.LifetimeSecurityException;
import org.testng.Assert;
import org.testng.annotations.Test;
import views.LifetimeView;

/**
 *
 * @author zua
 */
public class LifetimeUINGTest {

    /**
     *
     */
    public LifetimeUINGTest() {
    }

    /**
     * Test of getLanguage method, of class LifetimeUI. This test must throw
     * NullPointerException because this is a unit test, without session or
     * service context.
     *
     * @exception NullPointerException
     * @throws lifetime.persistence.exceptions.LifetimeSecurityException
     */
    @Test
    public void testGetLanguage() throws LifetimeSecurityException {
        System.out.println("getLanguage");
        LifetimeUI instance = new LifetimeUIImpl();
        Assert.assertEquals(instance.getLanguage(), "en");
    }

    /**
     * Test of getView method, of class LifetimeUI. This test must check that
     * class has a not initialized, i.e, null assigned {@link LifetimeView},
     * which will be implemented using the <b>bridge design pattern</b>.
     */
    @Test
    public void testGetView() {
        System.out.println("getView");
        LifetimeUI instance = new LifetimeUIImpl();
        Assert.assertNull(instance.getLifetimeView());
    }

    class LifetimeUIImpl extends LifetimeUI {

        @Override
        public void init(VaadinRequest request) {
        }
    }

}
