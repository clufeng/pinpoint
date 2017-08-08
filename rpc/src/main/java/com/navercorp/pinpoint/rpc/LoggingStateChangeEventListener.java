/*
 * Copyright 2017 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.rpc;

import com.navercorp.pinpoint.rpc.common.SocketStateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Taejin Koo
 */
public class LoggingStateChangeEventListener implements StateChangeEventListener<PinpointSocket> {

    public static final LoggingStateChangeEventListener INSTANCE = new LoggingStateChangeEventListener();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void eventPerformed(PinpointSocket pinpointSocket, SocketStateCode stateCode) throws Exception {
        logger.info("eventPerformed socket:{}, stateCode:{}", pinpointSocket, stateCode);
    }

    @Override
    public void exceptionCaught(PinpointSocket pinpointSocket, SocketStateCode stateCode, Throwable e) {
        logger.warn("exceptionCaught message:{}, socket:{}, stateCode:{}", e.getMessage(), pinpointSocket, stateCode, e);
    }

}
