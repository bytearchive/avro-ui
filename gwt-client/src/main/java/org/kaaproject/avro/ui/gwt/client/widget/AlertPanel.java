/*
 * Copyright 2014-2015 CyberVision, Inc.
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

package org.kaaproject.avro.ui.gwt.client.widget;

import static org.kaaproject.avro.ui.gwt.client.util.Utils.avroUiStyle;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;

public class AlertPanel extends Label {

    private DivElement textNode;

    public enum Type {
        INFO(avroUiStyle.info(), avroUiStyle.iconInfo()),
        HINT(avroUiStyle.hint(), avroUiStyle.iconHint()),
        WARNING(avroUiStyle.warning(), avroUiStyle.iconWarning()),
        ERROR(avroUiStyle.error(), avroUiStyle.iconError()),
        SUCCESS(avroUiStyle.success(), avroUiStyle.iconSuccess());

        String labelStyleName;

        String iconStyleName;

        Type(String _labelStyleName, String _iconStyleName) {
            labelStyleName = _labelStyleName;
            iconStyleName = _iconStyleName;
        }
    }

    public AlertPanel(Type type) {
        setStylePrimaryName(avroUiStyle.uiMessage());
        addStyleName(type.labelStyleName);

        InlineLabel icon = new InlineLabel();
        icon.setStylePrimaryName(avroUiStyle.uiIcon());
        icon.addStyleName(type.iconStyleName);

        getElement().appendChild(icon.getElement());
        textNode = Document.get().createDivElement();
        textNode.getStyle().setWidth(100, Unit.PCT);
        getElement().appendChild(textNode);
    }

    public void setMessage(String message) {
        textNode.setInnerHTML(message);
    }
}
