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
package lifetime.persistence.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Alexandre Zua Caldeira
 */
@ApplicationException(rollback = false)
public class LifetimeSecurityException extends Exception {

    static final long serialVersionUID = -3387516995463229948L;

    /**
     * Creates a new exception with the given message.
     *
     * @param message Message explaining the causes of this exception
     */
    public LifetimeSecurityException(String message) {
        super(message);
    }

    public LifetimeSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

}
