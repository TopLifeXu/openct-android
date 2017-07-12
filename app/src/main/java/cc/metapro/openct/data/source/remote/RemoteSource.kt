package cc.metapro.openct.data.source.remote

/*
 *  Copyright 2016 - 2017 OpenCT open source class table
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

import cc.metapro.openct.LoginConfig
import cc.metapro.openct.data.service.ServiceCenter
import cc.metapro.openct.data.source.Source
import cc.metapro.openct.data.university.DetailCustomInfo
import cc.metapro.openct.data.university.UniversityInfo
import io.reactivex.Observable
import java.io.IOException

class RemoteSource(private val SCHOOL_NAME: String) : Source {

    private val mService = ServiceCenter.createOpenCTService()

    override val universities: List<UniversityInfo>
        @Throws(IOException::class)
        get() = mService.universityInfo.execute().body()

    override val loginConfig: LoginConfig
        @Throws(IOException::class)
        get() = mService.getLoginConfigOf(SCHOOL_NAME).execute().body()

    override val detailCustomInfo: Observable<DetailCustomInfo>?
        get() = null
}
