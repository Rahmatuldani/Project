#!/bin/sh
GDK_NATIVE_WINDOWS=1
if [ "a" = "a$(uname -m | grep 64)" ]; then # computer is 32-bits
	unset UBUNTU_MENUPROXY; export GDK_NATIVE_WINDOWS=1; ./JETLXCmmty-linux-gtk-x86
else
	unset UBUNTU_MENUPROXY; export GDK_NATIVE_WINDOWS=1; ./JETLXCmmty-linux-gtk-x86_64
fi

