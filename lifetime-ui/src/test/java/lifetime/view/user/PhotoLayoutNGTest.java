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

import com.vaadin.ui.Upload;
import lifetime.util.ServiceLookupException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
public class PhotoLayoutNGTest {

    /**
     * Test of receiveUpload method, of class PhotoLayout.
     */
    @Test(expectedExceptions = {ServiceLookupException.class})
    public void testReceiveUpload() {
        System.out.println("receiveUpload");
        PhotoLayout photoLayout = new PhotoLayout("username");
        Assert.assertNotNull(photoLayout.receiveUpload("tmp", null));
    }

    /**
     * Test of uploadSucceeded method, of class PhotoLayout.
     */
    @Test(expectedExceptions = ServiceLookupException.class)
    public void testUploadSucceeded() {
        System.out.println("uploadSucceeded");
        PhotoLayout photoLayout = new PhotoLayout("username");
        photoLayout.uploadSucceeded(new Upload.SucceededEvent(new Upload(), "tmp", null, 1024));
    }

    /**
     * Test of hashCode method, of class PhotoLayout.
     *
     * @param photo
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testHashCode(PhotoLayout photo, PhotoLayout other) {
        System.out.println("hashCode");
        Assert.assertEquals(photo.hashCode(), other.hashCode());
    }

    /**
     * Test of equals method, of class PhotoLayout.
     *
     * @param photo
     * @param other
     */
    @Test(dataProvider = "equals")
    public void testEquals(PhotoLayout photo, PhotoLayout other) {
        System.out.println("equals");
        Assert.assertTrue(photo.equals(other));
    }

    /**
     * Test of equals method, of class PhotoLayout.
     *
     * @param photo
     * @param other
     */
    @Test(dataProvider = "inequals")
    public void testInequals(PhotoLayout photo, Object other) {
        System.out.println("inequals");
        Assert.assertFalse(photo.equals(other));
    }

    @DataProvider(name = "equals")
    private Object[][] provideEqualsData() {
        PhotoLayout photoLayout1 = new PhotoLayout("username");
        PhotoLayout photoLayout2 = new PhotoLayout("username");
        return new Object[][]{
            {photoLayout1, photoLayout2},
            {photoLayout2, photoLayout1}
        };
    }

    @DataProvider(name = "inequals")
    private Object[][] provideInequalsData() {
        PhotoLayout photoLayout1 = new PhotoLayout("username1");
        PhotoLayout photoLayout2 = new PhotoLayout("username2");
        return new Object[][]{
            {photoLayout1, photoLayout2},
            {photoLayout1, null},
            {photoLayout1, ""}
        };
    }

}
