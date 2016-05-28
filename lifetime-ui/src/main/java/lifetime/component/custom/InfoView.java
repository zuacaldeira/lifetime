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
package lifetime.component.custom;

import com.vaadin.server.Resource;
import com.vaadin.ui.Label;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author zua
 */
public class InfoView extends IconedLabeledInfoView {

    private static final DecimalFormat format = new DecimalFormat("###,###");
    private final String tag;
    private final transient Object value;

    public InfoView(String key, Object value) {
        this(key, value, null);
    }

    public InfoView(String key, Object value, Resource icon) {
        super(new Label(value.toString() + " " + key), icon);
        this.tag = key;
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.tag);
        hash = 79 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InfoView other = (InfoView) obj;
        return Objects.equals(this.tag, other.tag) && Objects.equals(this.value, other.value);
    }

}
