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
package old.ui.form;

import old.util.ServiceLocator;
import java.util.Date;
import lifetime.business.persistence.Certification;
import old.ui.list.LifetimeList;

/**
 *
 * @author lifetime
 */
public class CertificationFormNew extends CertificationFormEdit {

    public CertificationFormNew(Certification c, LifetimeList<Certification> list) {
        super(c, list);
    }

    @Override
    protected void commitItem() {
        Certification certification = getItem();
        certification.setCreatedAt(new Date());
        ServiceLocator.findLifetimeService().add(certification);
    }
    
}