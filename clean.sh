pkill -f org.eclipse.equinox; rm -rf ~/.cache/jdtls-*
rm -rf .project .settings .classpath app/.project app/.classpath app/.settings app/bin
./gradlew clean
