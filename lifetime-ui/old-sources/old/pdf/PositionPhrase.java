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

import com.itextpdf.text.Phrase;

/**
 *
 * @author lifetime
 */
public class PositionPhrase extends Phrase {

    public PositionPhrase(String position) {
        super(position, LifetimeFonts.FONT_BOLD);
    }
    
}
