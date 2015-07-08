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
package old.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import java.util.Locale;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Certification;
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Other;
import lifetime.business.persistence.Professional;
import lifetime.business.persistence.Social;

/**
 *
 * @author lifetime
 */
public class SummaryPhrase extends Phrase {

    public SummaryPhrase(Academic aux) {
        super();
        if (aux.getDegree() != null) {
            add(new DegreePhrase(aux.getDegree().getFullname()));
            add(new KeyPhrase(" in ", aux.getLanguage()));
        }
        add(new CoursePhrase(aux.getCourse().getName()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }

    public SummaryPhrase(Professional aux) {
        super();
        add(new PositionPhrase(aux.getPosition().getName()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }

    public SummaryPhrase(Certification aux) {
        super();
        if (aux.getDegree()!= null) {
            add(new DegreePhrase(aux.getDegree().getFullname()));
            add(new KeyPhrase(" in ", aux.getLanguage()));
        }
        add(new CoursePhrase(aux.getCourse().getName()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }

    public SummaryPhrase(Linguistic aux) {
        super();
        Locale l = new Locale(aux.getName());
        add(new LanguagePhrase(l.getDisplayLanguage(new Locale(aux.getLanguage()))));
        add(Chunk.NEWLINE);
        add(new LevelPhrase(aux.getLevel()));
        if(aux.getOrganization() != null) {
            add(new OrganizationPhrase(aux.getOrganization()));
        }
    }

    public SummaryPhrase(Social aux) {
        super();
        add(new DegreePhrase(aux.getTitle()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }

    public SummaryPhrase(Entrepeneurship aux) {
        super();
        add(new PositionPhrase(aux.getPosition().getName()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }

    public SummaryPhrase(Other aux) {
        super();
        add(new PositionPhrase(aux.getTitle()));
        add(Chunk.NEWLINE);
        add(new OrganizationPhrase(aux.getOrganization()));
    }
}
