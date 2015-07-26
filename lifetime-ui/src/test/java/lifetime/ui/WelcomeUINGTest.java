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
import javax.servlet.ServletException;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    @Test(expectedExceptions = NullPointerException.class)
    public void testInit() {
        System.out.println("testInit()");
        VaadinRequest request = null;
        WelcomeUI instance = new WelcomeUI();
        instance.init(request);
        Assert.assertNotNull(instance.getNavigator());
    }

    @Test
    public void testServlet() throws ServletException {
        System.out.println("testServlet()");
        WelcomeUI.WelcomeUIServlet servlet = new WelcomeUI.WelcomeUIServlet();
        servlet.init();
    }

}
