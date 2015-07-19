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

import lifetime.ui.WelcomeUI;
import com.vaadin.server.VaadinRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import lifetime.view.WelcomeView;

/**
 * Unit test suite for the {@link WelcomeUI} class. This test is responsible to
 * verify that it extends from {@link LifetimeUI}, and that provides an
 * implementation for the for the lifetime view; this means the class provides a
 * correct implementation of the <b>bridge design pattern</b>, one of it's
 * contractual requirements.
 *
 * @author zua
 */
public class WelcomeUINGTest {

    /**
     * Default constructor.
     */
    public WelcomeUINGTest() {
    }

    /**
     * Test of init method, of class WelcomeUI. In the unit test environment,
     * the method init does not have session context.
     *
     * @exception NullPointerException
     * @todo {@link WelcomeUISeleniumTest}
     */
    @Test(expectedExceptions = {NullPointerException.class})
    public void testInit() {
        System.out.println("init");
        VaadinRequest request = null;
        WelcomeUI instance = new WelcomeUI();
        instance.init(request);
    }

    /**
     * Test of getLifetimeView method, of class WelcomeUI. The test should
     * verify that method {@link WelcomeUI#getLifetimeView()} correctly returns
     * a reference of type {@link WelcomeView}, as expected by the <b>bridge
     * design pattern</b>.
     *
     * @exception NullPointerException
     * @todo {@link WelcomeUISeleniumTest}
     */
    @Test
    public void testGetLifetimeView() {
        System.out.println("getLifetimeView");
        WelcomeUI instance = new WelcomeUI();
        Assert.assertNull((WelcomeView) instance.getLifetimeView());
    }

}
