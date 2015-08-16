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
package lifetime.util;

import lifetime.util.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class LocationNGTest {

    public LocationNGTest() {
    }

    /**
     * Test of values method, of class Location.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Assert.assertEquals(Location.values(), new Location[]{Location.HOME, Location.USER});
    }

    /**
     * Test of valueOf method, of class Location.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        Assert.assertEquals(Location.valueOf(Location.HOME.name()), Location.HOME);
        Assert.assertEquals(Location.valueOf(Location.USER.name()), Location.USER);
    }

    /**
     * Test of getUri method, of class Location.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        Assert.assertEquals(Location.HOME.getUri(), "/lifetime");
        Assert.assertEquals(Location.USER.getUri(), "/lifetime/user");
    }

}
