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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ProfileSummaryLayoutNGTest {

    private String USERNAME;

    /**
     * Test of hashCode method, of class ProfileSummaryLayout.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME);
        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class ProfileSummaryLayout.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME);
        assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class ProfileSummaryLayout.
     */
    @Test
    public void testInequals() {
        System.out.println("inequals");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME+"a");
        ProfileSummaryLayout instance3 = null;
        String instance4 = "";
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(instance4));
    }
}
