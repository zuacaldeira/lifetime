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
package lifetime.logic.timeline;

/**
 *
 * @author zua
 * @param <X>
 * @param <Y>
 */
public class Plan<X extends Axis, Y extends Axis> {

    private X xAxis;
    private Y yAxis;

    public Plan(X xAxis, Y yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public X getxAxis() {
        return xAxis;
    }

    public void setxAxis(X xAxis) {
        this.xAxis = xAxis;
    }

    public Y getyAxis() {
        return yAxis;
    }

    public void setyAxis(Y yAxis) {
        this.yAxis = yAxis;
    }

}
