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
package lifetime.ui;

import com.vaadin.server.VaadinRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import lifetime.view.LifetimeView;
import lifetime.view.welcome.WelcomeView;

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
     */
    @Test
    public void testGetLanguage() {
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
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        LifetimeUI instance1 = new LifetimeUIImpl();
        LifetimeUI instance2 = new LifetimeUIImpl();
        Assert.assertTrue(instance1.equals(instance2));
        Assert.assertFalse(instance1.equals(null));
        Assert.assertFalse(instance1.equals(""));
    }
    
    @Test
    public void testSetLifetimeView() {
        System.out.println("equals");
        LifetimeUI instance = new LifetimeUIImpl();
        Assert.assertNull(instance.getLifetimeView());
        
        LifetimeView lv = new WelcomeView("pt");
        instance.setLifetimeView(lv);
        Assert.assertEquals(instance.getLifetimeView(), lv);
        
    }

    public class LifetimeUIImpl extends LifetimeUI {

        @Override
        public void init(VaadinRequest request) {
            // do nothing
        }
    }

}
