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
package lifetime.view.user;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class AccountDetailsLayoutNGTest {

    private final String USERNAME = "username";
    private final String USERNAME2 = "username2";

    /**
     * Test of hashCode method, of class AccountDetailsLayout.
     *
     * @param details1
     * @param details2
     */
    @Test(dataProvider = "equalsProvider")
    public void testHashCode(AccountDetailsLayout details1, AccountDetailsLayout details2) {
        System.out.println("hashCode");
        Assert.assertEquals(details1.hashCode(), details2.hashCode());
    }

    @DataProvider(name = "equalsProvider")
    private Object[][] provideEqualsData() {
        return new Object[][]{
            {new AccountDetailsLayout(USERNAME, "pt"), new AccountDetailsLayout(USERNAME, "pt")}
        };
    }

    @DataProvider(name = "inequalsProvider")
    private Object[][] provideInequalsData() {
        return new Object[][]{
            {new AccountDetailsLayout(USERNAME, "pt"), new AccountDetailsLayout(USERNAME2, "en")},
            {new AccountDetailsLayout(USERNAME, "pt"), null},
            {new AccountDetailsLayout(USERNAME, "pt"), "Hi"}
        };
    }

    /**
     * Test of equals method, of class AccountDetailsLayout.
     *
     * @param details1
     * @param details2
     */
    @Test(dataProvider = "equalsProvider")
    public void testEquals(AccountDetailsLayout details1, AccountDetailsLayout details2) {
        System.out.println("equals");
        assertTrue(details1.equals(details2));
    }

    /**
     * Test of equals method, of class AccountDetailsLayout.
     *
     * @param details1
     * @param details2
     */
    @Test(dataProvider = "inequalsProvider")
    public void testInequals(AccountDetailsLayout details1, Object details2) {
        System.out.println("inequals");
        assertFalse(details1.equals(details2));
    }

}
