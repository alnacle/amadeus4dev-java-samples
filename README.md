# Java Samples

Welcome to the Amadeus for Developers Java Samples and Snippets

# Setup

The samples have been compiled using `AdoptOpenJDK 8`. We recommend to use
`brew` if possible:

```
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk8
```

# Run

Managing a Java project and dependencies manually can be an exhausting task if
you don't use the proper tools or IDEs (Eclipse, NetBeans, IntelliJ...). This
tutorial is meant to be followed using the command line to give a better
understanding beneath any IDE.

There are several tools which can make a Java project easier, we recommend
`Gradle` and `maven`.

Although our Java SDK supports both Gradle and maven, for our example we are
going to use `Gradle`:

```
brew install gradle
```

Finally, switch to the sample folder and run:

```
gradle run
```

