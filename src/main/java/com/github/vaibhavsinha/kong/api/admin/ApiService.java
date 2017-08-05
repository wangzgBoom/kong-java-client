package com.github.vaibhavsinha.kong.api.admin;

import com.github.vaibhavsinha.kong.model.admin.api.Api;
import com.github.vaibhavsinha.kong.model.admin.api.ApiList;
import com.github.vaibhavsinha.kong.model.admin.plugin.PluginList;

/**
 * Created by vaibhav on 13/06/17.
 */
public interface ApiService {
    Api createApi(Api request);
    Api getApi(String nameOrId);
    Api updateApi(String nameOrId, Api request);
    Api createOrUpdateApi(Api request);
    Api deleteApi(String usernameOrId);
    ApiList listApis(String id, String upstreamUrl, String name, Long retries, Long size, String offset);
    PluginList listApiPlugins(String id);
}
