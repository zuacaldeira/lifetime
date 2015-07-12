/*
 * Copyright 2015 lifetime.
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
package old.ui.button;

import old.ui.button.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;

/**
 *
 * @author lifetime
 */
public class DonateLink extends LifetimeButtonLink {

    private String link;
    
    public DonateLink(String caption, FontAwesome icon) {
        super(caption, icon);
        link = "https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=zuacaldeira%40gmail%2ecom&lc=US&item_name=vitae&item_number=development&no_note=0&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest";
    }
    
    public String getLink() {
        return link;
    }
    
}
