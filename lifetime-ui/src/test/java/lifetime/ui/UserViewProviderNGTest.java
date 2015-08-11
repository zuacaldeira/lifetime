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

import lifetime.backend.util.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UserViewProviderNGTest {

    public UserViewProviderNGTest() {
    }

    /**
     * Test of getViewName method, of class UserViewProvider.
     */
    @Test
    public void testGetViewName() {
        System.out.println("getViewName");
        UserViewProvider provider = new UserViewProvider(TestHelper.getRandomString(), "pt");
        Assert.assertEquals(provider.getViewName(Navigation.USER_VIEW.getName()), Navigation.USER_VIEW.getName());
    }

    /**
     * Test of getView method, of class UserViewProvider.
     */
    @Test
    public void testGetView() {
        System.out.println("getView");
        UserViewProvider provider = new UserViewProvider(TestHelper.getRandomString(), "pt");
        Assert.assertNotNull(provider.getView(provider.getViewName(Navigation.USER_VIEW.getName())));
    }

}
