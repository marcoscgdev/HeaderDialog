# HeaderDialog
An android library to display a material-designed dialog with header.

---

## Releases:

#### Current release: 1.0.1.

You can see all the library releases [here](https://github.com/marcoscgdev/HeaderDialog/releases).

---

##Screenshots

<img src="https://raw.githubusercontent.com/marcoscgdev/HeaderDialog/master/screenshots/1.jpg" width="350">
<img src="https://raw.githubusercontent.com/marcoscgdev/HeaderDialog/master/screenshots/2.jpg" width="350">

<a href='#'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height='90'/></a>

---

## Usage:

#### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Now add the dependency to your app build.gradle file:

```
compile 'com.github.marcoscgdev:HeaderDialog:1.0.1'
```

Here is a complete snippet of the usage:

```
new HeaderDialog(this)
                .setColor(getResources().getColor(R.color.colorAccent))
                .setIcon(getResources().getDrawable(R.drawable.ic_info_outline_black_48dp))
                .setTitle(getResources().getString(R.string.library_name))
                .setMessage(Html.fromHtml(msg))
                .justifyContent(false) // Default false
                .setTitleColor(Color.parseColor("#212121"))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Your action
                    }
                })
                .setNegativeButton("Close", null)
                .show();
```

---
>See the *sample project* to clarify any queries you may have.

---

##License

```
The MIT License (MIT)

Copyright (c) 2017 Marcos Calvo García

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

