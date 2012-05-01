/*
 * Copyright 2012 GitHub Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.mobile.ui.user;

import com.github.mobile.core.ResourcePager;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.PageIterator;

/**
 * Fragment to display a list of followers
 */
public class MyFollowersFragment extends FollowersFragment {

    @Override
    protected ResourcePager<User> createPager() {
        return new ResourcePager<User>() {

            @Override
            protected Object getId(User resource) {
                return resource.getId();
            }

            @Override
            public PageIterator<User> createIterator(int page, int size) {
                return userService.pageFollowers(page, size);
            }
        };
    }
}