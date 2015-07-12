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
package util;

import old.Academic;
import old.Achievement;
import old.Certification;
import old.Entrepeneurship;
import old.Linguistic;
import old.Other;
import old.Professional;
import old.Social;

/**
 *
 * @author lifetime
 */
class TypeAscendingEndComparator extends AchievementComparator {

    @Override
    public int compare(Achievement o1, Achievement o2) {
        if (o1.getClass().equals(o2.getClass())) {
            AscendingEndComparator comparator = new AscendingEndComparator();
            return comparator.compare(o1, o2);
        } else {
            if (o1 instanceof Professional) {
                return 1;
            }

            if (o2 instanceof Professional) {
                return -1;
            }

            if (o1 instanceof Academic) {
                return 1;
            }

            if (o2 instanceof Academic) {
                return -1;
            }

            if (o1 instanceof Certification) {
                return 1;
            }

            if (o2 instanceof Certification) {
                return -1;
            }

            if (o1 instanceof Entrepeneurship) {
                return 1;
            }

            if (o2 instanceof Entrepeneurship) {
                return -1;
            }

            if (o1 instanceof Social) {
                return 1;
            }

            if (o2 instanceof Social) {
                return -1;
            }

            if (o1 instanceof Linguistic) {
                return 1;
            }

            if (o2 instanceof Linguistic) {
                return -1;
            }

            if (o1 instanceof Other) {
                return 1;
            } 
            
            if (o2 instanceof Other) {
                return -1;
            } 
            
            else {
                AscendingEndComparator comparator = new AscendingEndComparator();
                return comparator.compare(o1, o2);
            }
        }
    }

}
