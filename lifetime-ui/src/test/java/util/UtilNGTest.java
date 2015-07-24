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
package util;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class UtilNGTest {

    public UtilNGTest() {
    }

    /**
     * Test of getEncodedPassword method, of class Util.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetEncodedPassword() throws Exception {
        System.out.println("getEncodedPassword");
        String clearTextPassword = "OKOKOKOKOKOKOKOKK";
        String result = Util.getEncodedPassword(clearTextPassword);
        assertEquals(result, new Util().getEncodedPassword(clearTextPassword));
    }

}
