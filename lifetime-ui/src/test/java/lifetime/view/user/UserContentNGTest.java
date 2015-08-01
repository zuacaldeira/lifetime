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
public class UserContentNGTest {

    /**
     * Test of hashCode method, of class UserContent.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserContent instancePt1 = new UserContent("pt");
        UserContent instancePt2 = new UserContent("pt");
        UserContent instanceEn1 = new UserContent("en");
        UserContent instanceEn2 = new UserContent("en");
        assertEquals(instancePt1.hashCode(), instancePt2.hashCode());
        assertEquals(instanceEn1.hashCode(), instanceEn2.hashCode());
        assertNotEquals(instancePt1.hashCode(), instanceEn1.hashCode());
        assertNotEquals(instancePt2.hashCode(), instanceEn2.hashCode());
    }

    /**
     * Test of equals method, of class UserContent.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        UserContent instancePt1 = new UserContent("pt");
        UserContent instancePt2 = new UserContent("pt");
        UserContent instanceEn1 = new UserContent("en");
        UserContent instanceEn2 = new UserContent("en");
        assertTrue(instancePt1.equals(instancePt2));
        assertTrue(instanceEn1.equals(instanceEn2));
        assertFalse(instancePt1.equals(instanceEn1));
        assertFalse(instancePt2.equals(instanceEn2));
    }

    /**
     * Test of equals method, of class UserContent.
     */
    @Test
    public void testInequals() {
        System.out.println("inequals");
        UserContent instancePt = new UserContent("pt");
        UserContent instanceEn = new UserContent("en");
        assertFalse(instancePt.equals(instanceEn));
        assertFalse(instanceEn.equals(instancePt));
        assertFalse(instancePt.equals(null));
        assertFalse(instancePt.equals(""));
    }

}
