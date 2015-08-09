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

import java.util.Date;
import lifetime.backend.persistence.User;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ProfileSummaryLayoutNGTest {

    private String USERNAME;
    private User u = new User(null, "Alexandre", "Z. Caldeira", new Date(), "Piri, Angola", "pt");

    /**
     * Test of hashCode method, of class ProfileSummaryLayout.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME, u);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME, u);
        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class ProfileSummaryLayout.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME, u);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME, u);
        assertTrue(instance.equals(instance2));
    }

    /**
     * Test of equals method, of class ProfileSummaryLayout.
     */
    @Test
    public void testInequals() {
        System.out.println("inequals");
        ProfileSummaryLayout instance = new ProfileSummaryLayout(USERNAME, u);
        ProfileSummaryLayout instance2 = new ProfileSummaryLayout(USERNAME + "a", u);
        ProfileSummaryLayout instance3 = null;
        String instance4 = "";
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(instance4));
    }
}
