# redundant-file-entries-resolver

This swing application provides a very simple search for finding
redundant files. It is simple to use. The user have to set two
directories which will be search in and than compared. You can set five file attributes as search criteria for how
the files are going to be compared.

# Features

- Search for files with the same or similar filename
- Compare arbitrary files byte by byte (files which have the same content, but do not necessarily have the same file name) 
- Find duplicate large VIDEO or MP-3 files that shrinking your hard drives and save money and time
- Compare existing files collections and find doublets or even triplets
- File search options are by extension, length, last modified, filename or file content

In companies administrators can seek the files from the employee for unnecessary file copies and redundant Backups.

# Install

Windows, Linux and Mac users can download and install it from [izpack installer](https://sourceforge.net/projects/findsamefiles/files/latest/download).

For users that want it build from the source files can clone this git repository. It a maven project so you will need maven and a java JDK.

Than compile the project:

```
mvn clean install
```

## License

The source code comes under the liberal Apache License V2.0, making jgeohash great for all types of applications.


