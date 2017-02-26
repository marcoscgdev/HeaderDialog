# HeaderDialog  [![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-HeaderDialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5076)
An android library to display a material-designed dialog with header.

---

## Releases:

#### Current release: 1.0.3.

You can see all the library releases [here](https://github.com/marcoscgdev/HeaderDialog/releases).

---

##Screenshots

<img src="https://raw.githubusercontent.com/marcoscgdev/HeaderDialog/master/screenshots/1.jpg" width="350">
<img src="https://raw.githubusercontent.com/marcoscgdev/HeaderDialog/master/screenshots/2.jpg" width="350">

<a href='https://play.google.com/store/apps/details?id=com.marcoscg.headerdialogsample'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height='90'/></a>

---

## Features

- Roboto font
- LinkMovementMethod support
- Justify text option
- Icon, text and both as header
- Custom header background color
- Custom header text color
- Custom header icon color (NEW)
- Custom header text gravity (NEW)
- Custom message text gravity (NEW)
- Show or hide header shadow (NEW)
- Multiline title text option (NEW)
- Arabic text support (NEW)

---

## Usage:

### Adding the depencency

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
compile 'com.github.marcoscgdev:HeaderDialog:1.0.3'
```

### Creating the dialog

Here is a complete snippet of it usage:

```
new HeaderDialog(this)
                .setColor(getResources().getColor(R.color.colorAccent)) // Sets the header background color
                .setElevation(false) // Sets the header elevation, true by default
                .setIcon(getResources().getDrawable(R.drawable.ic_info_outline_black_48dp)) // Sets the dialog icon image
                .setTitle(getResources().getString(R.string.library_name)) // Sets the dialog title
                .setMessage("Lorem ipsum dolor sit amet...") // Sets the dialog message
                .justifyContent(true) // Justifies the message text, false by default
                .setTitleColor(Color.parseColor("#212121")) // Sets the title text color
                .setIconColor(Color.parseColor("#212121")) // Sets the icon color
                .setTitleGravity(Gravity.CENTER_HORIZONTAL) // Sets the title text gravity
		.setMessageGravity(Gravity.CENTER_HORIZONTAL); // Sets the message text gravity
		.setTitleMultiline(false) // Multiline title text option
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Your action
                    }
                })
                .setNegativeButton("Close", null)
                .show();
```

#### Important note: Do not enable the justified text if you are using html content!

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

