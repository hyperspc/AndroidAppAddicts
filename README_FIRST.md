While not necessary to setup, we recommend that you add the modules as git subtree's so you can contribute changes
and update your code as the module code changes.

AndroidViewUtils
----------------
* Add the module as a remote `git remote add -f AndroidViewUtils git@github.com:Sage42/AndroidViewUtils.git`
* Fetch the latest copy `git fetch AndroidViewUtils master`
* Merge any changes `git subtree pull --prefix modules/AndroidViewUtils AndroidViewUtils master --squash`


git remote add -f AndroidViewUtils git@github.com:Sage42/AndroidViewUtils.git
git subtree add --prefix modules/AndroidViewUtils AndroidViewUtils master --squash
git fetch AndroidViewUtils master
git subtree pull --prefix modules/AndroidViewUtils AndroidViewUtils master --squash
