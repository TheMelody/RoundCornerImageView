#RoundCornerImageView
A variable number of rounded corners

Preview
======================
![Icon Round Corner Progress Bar Usage](https://github.com/TheMelody/RoundCornerImageView/blob/master/Screenshot_20160612-180205~2.png
)
![Icon Round Corner Progress Bar Usage](https://github.com/TheMelody/RoundCornerImageView/blob/master/Screenshot_20160612-183629~2.png
)
![Icon Round Corner Progress Bar Usage](https://github.com/TheMelody/RoundCornerImageView/blob/master/Screenshot_20160612-183821~2.png
)
![Icon Round Corner Progress Bar Usage](https://github.com/TheMelody/RoundCornerImageView/blob/master/Screenshot_20160612-183928~2.png
)
Usage
======================
Define 'app' namespace on root view in your layout
```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```
Include this RoundCornerImageView library in your layout
```xml
 <org.devloper.melody.roundcornerimageview.RoundCornerImageView
        android:layout_marginTop="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:background="@drawable/yuner02"
        app:roundHeight="10dp"
        app:roundWidth="10dp"
        app:round_all="false"
        app:round_orientation="left_down|right_down"/>
```
Attribute Edit
==========================
<h3>First</h3>

If you use the
```xml
 app:round_all="true"
```
property, there is no need to use
```xml
 app:round_orientation="xxxx"
```
properties

<h4>Second</h4>
```xml
 app:round_all="false"
 ```
<h4>Next</h4>
```xml
 app:round_orientation="left_down|right_down|left_up|right_up"
```
or
```xml
 app:round_orientation="left_down|right_down"
```
or
```xml
 app:round_orientation="left_up"
```
<h5>ect</h5>

Licence
===========================
Copyright 2016 TheMelody

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
