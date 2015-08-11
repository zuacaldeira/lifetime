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

import lifetime.backend.util.TestHelper;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class ProfileViewNGTest {

    /**
     * Test of hashCode method, of class ProfileView.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String username = TestHelper.getRandomString();
        ProfileView instancePt1 = new ProfileView(username, "pt");
        ProfileView instancePt2 = new ProfileView(username, "pt");
        ProfileView instanceEn1 = new ProfileView(username, "en");
        ProfileView instanceEn2 = new ProfileView(username, "en");
        assertEquals(instancePt1.hashCode(), instancePt2.hashCode());
        assertEquals(instanceEn1.hashCode(), instanceEn2.hashCode());
        assertNotEquals(instancePt1.hashCode(), instanceEn1.hashCode());
        assertNotEquals(instancePt2.hashCode(), instanceEn2.hashCode());
    }

    /**
     * Test of equals method, of class ProfileView.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String username = TestHelper.getRandomString();
        ProfileView instancePt1 = new ProfileView(username, "pt");
        ProfileView instancePt2 = new ProfileView(username, "pt");
        ProfileView instanceEn1 = new ProfileView(username, "en");
        ProfileView instanceEn2 = new ProfileView(username, "en");
        assertTrue(instancePt1.equals(instancePt2));
        assertTrue(instanceEn1.equals(instanceEn2));
        assertFalse(instancePt1.equals(instanceEn1));
        assertFalse(instancePt2.equals(instanceEn2));
    }

    /**
     * Test of equals method, of class ProfileView.
     */
    @Test
    public void testInequals() {
        System.out.println("inequals");
        ProfileView instancePt = new ProfileView(TestHelper.getRandomString(), "pt");
        ProfileView instanceEn = new ProfileView(TestHelper.getRandomString(), "en");
        assertFalse(instancePt.equals(instanceEn));
        assertFalse(instanceEn.equals(instancePt));
        assertFalse(instancePt.equals(null));
        assertFalse(instancePt.equals(""));
    }

}
