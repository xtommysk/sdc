/*!
 * Copyright © 2016-2018 European Support Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
import keyMirror from 'nfvo-utils/KeyMirror.js';

export const actionTypes = keyMirror(
    {
        FETCH_SOFTWARE_PRODUCT_DEPLOYMENT_FLAVORS: null,

        deploymentFlavorEditor: {
            DATA_CHANGED: null,
            SOFTWARE_PRODUCT_DEPLOYMENT_FILL_DATA: null,
            SOFTWARE_PRODUCT_DEPLOYMENT_CLEAR_DATA: null
        }
    },
    'softwareProductDeployment'
);

export const DEPLOYMENT_FLAVORS_FORM_NAME = 'DEPLOYMENT_FLAVORS_FORM_NAME';
