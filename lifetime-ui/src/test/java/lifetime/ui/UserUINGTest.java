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

import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserUINGTest {

    /**
     * Test of init method, of class UserUI.
     */
    @Test(expectedExceptions = NullPointerException.class)
    public void testInit() {
        System.out.println("testInit()");
        UserUI instance = new UserUI();
        instance.init(null);
    }

    /**
     * Test of init method, of class UserUI.
     */
    @Test
    public void testServlet() {
        System.out.println("testServlet()");
        UserUI.UserUIServlet servlet = new UserUI.UserUIServlet();
        //Assert.assertNull(servlet.getServletContext());
    }

}
