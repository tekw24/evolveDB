/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2022 DBeaver Corp and others
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
package de.thm.mdde.connection.ui.utils;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import de.thm.connection.ui.DBPImage;
import de.thm.mdde.connection.utils.CommonUtils;
import de.thm.mdde.connection.utils.NotNull;
import de.thm.mdde.connection.utils.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public final class MessageBoxBuilder {
    private final MessageBoxModern dialog;

    @Nullable
    private List<Reply> replies;
    @Nullable
    private Reply defaultReply;

    private MessageBoxBuilder(@Nullable Shell shell) {
        dialog = new MessageBoxModern(shell);
    }

    public static MessageBoxBuilder builder(@Nullable Shell shell) {
        return new MessageBoxBuilder(shell);
    }

    public static MessageBoxBuilder builder() {
        return new MessageBoxBuilder(null);
    }

    // ----- Builder methods

    @NotNull
    public MessageBoxBuilder setTitle(@NotNull String title) {
        dialog.setTitle(title);
        return this;
    }

    @NotNull
    public MessageBoxBuilder setMessage(@NotNull String message) {
        dialog.setMessage(message);
        return this;
    }

    @NotNull
    public MessageBoxBuilder setPrimaryImage(@NotNull DBPImage image) {
        dialog.setPrimaryImage(image);
        return this;
    }

    @NotNull
    public MessageBoxBuilder setReplies(@NotNull Reply... replies) {
        this.replies = new ArrayList<>(Arrays.asList(replies));
        return this;
    }

    @NotNull
    public MessageBoxBuilder setDefaultReply(@NotNull Reply defaultReply) {
        this.defaultReply = defaultReply;
        return this;
    }
    
    @NotNull
    public MessageBoxBuilder setCustomArea(@NotNull Consumer<? super Composite> customArea) {
        dialog.setCustomArea(customArea);
        return this;
    }

    // -----

    @Nullable
    public Reply showMessageBox() {
        // create labels from replies, find default reply
        List<String> labels;
        int defaultIdx = 0;
        if (replies != null) {
            labels = new ArrayList<>(replies.size());
            for (int i = 0; i < replies.size(); i++) {
                Reply reply = replies.get(i);
                if (reply == defaultReply) {
                    defaultIdx = i;
                }
                labels.add(reply != null ? reply.getDisplayString() : "[null]");
            }
        } else {
            labels = Collections.emptyList();
        }
        dialog.setLabels(labels);
        dialog.setDefaultAnswerIdx(defaultIdx);

        // Open dialog, detect reply
        int answerIdx = dialog.open();
        if (replies == null || !CommonUtils.isValidIndex(answerIdx, replies.size())) {
            return null;
        }
        return replies.get(answerIdx);
    }
}