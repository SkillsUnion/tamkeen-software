
# Installing Eclipse Temurin JDK 17 on Ubuntu

This guide provides detailed instructions on how to download and install Eclipse Temurin JDK 17 on Ubuntu using a `.tar.gz` file. The instructions are designed for complete beginners.

## Prerequisites

- Access to a computer running Ubuntu.
- Basic knowledge of using a terminal.

## Step-by-Step Installation
First Watch the following video and then follow the instructions provided below from Step 1 onwards:

<iframe width="560" height="315" src="https://www.youtube.com/embed/0F-MVN8gAfk?si=2_qiYm3P_xi6ujgp" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

### Step 1: Update Your System

Before installing any new software, it's a good practice to update your package repository to ensure you install the latest versions of the software.

Open a terminal and execute the following command:

```bash
sudo apt update && sudo apt upgrade -y
```

### Step 2: Download the JDK Tarball

1. **Open your web browser** and go to [Adoptium.net](https://adoptium.net/).
2. Select **Temurin 17** from the list of available JDK versions.
3. Click on the **Linux x64** link to download the `.tar.gz` file for Linux.

### Step 3: Extract the JDK

1. Once the download is complete, open a terminal.
2. Navigate to the directory where the file was downloaded. Typically, this is the `Downloads` folder:

```bash
cd ~/Downloads
```

3. Use the `ls` command to find the name of the downloaded tarball. It will look similar to `OpenJDK17U-jdk_x64_linux_hotspot_17.0.3_7.tar.gz`.

```bash
ls *.tar.gz
```

You'll see a file named similar to `OpenJDK17U-jdk_x64_linux_hotspot_17.0.3_7.tar.gz`. This is the file you need to extract.

4. Extract the tarball to the desired installation directory (e.g., `/usr/lib/jvm/`). You might need `sudo` permissions to extract to this directory:

```bash
sudo tar -xzf OpenJDK17U-jdk_x64_linux_hotspot_17.0.3_7.tar.gz -C /usr/lib/jvm/
```

**Example:** If the `ls` command shows that your download file is named `temurin-17-jdk-linux.tar.gz`, you would replace the command with:

```bash
sudo tar -xzf temurin-17-jdk-linux.tar.gz -C /usr/lib/jvm/
```

Make sure to replace `temurin-17-jdk-linux.tar.gz` with the actual file name from the `ls` output.

### Step 4: Set Environment Variables

1. Find the exact path where JDK was extracted by listing the contents of the installation directory:

```bash
ls /usr/lib/jvm/
```

Note down the directory name which should look like `jdk-17.0.3`.

2. Open your `.bashrc` file in a text editor, such as nano:

```bash
nano ~/.bashrc
```

3. Add the following lines at the end of the file, using the directory name you noted earlier:

```bash
export JAVA_HOME=/usr/lib/jvm/jdk-17.0.3
export PATH=$PATH:$JAVA_HOME/bin
```

Replace `jdk-17.0.3` with the actual JDK directory name.

**Example:** If the directory is named `temurin-17-jdk-amd64`, you would modify the line to:

```bash
export JAVA_HOME=/usr/lib/jvm/temurin-17-jdk-amd64
```

4. Save and exit nano (press `Ctrl+X`, then `Y`, and hit `Enter`).

5. Apply the changes to your current session:

```bash
source ~/.bashrc
```

### Step 5: Verify the Installation

Check that the installation was successful by running:

```bash
java -version
```

You should see output indicating that JDK 17 is installed, like this:

```plaintext
openjdk version "17.0.3" 2022-04-19
OpenJDK Runtime Environment Temurin-17.0.3+7 (build 17.0.3+7)
OpenJDK 64-Bit Server VM Temurin-17.0.3+7 (build 17.0.3+7, mixed mode, sharing)
```

## Troubleshooting

Here are some common issues that you might encounter during the installation process and how to troubleshoot them:

### Issue: Permission Denied While Extracting the File

If you receive a `Permission denied` error when trying to extract the JDK, ensure that you have the necessary permissions to write to the `/usr/lib/jvm/` directory. Using `sudo` usually resolves this issue.

### Issue: `java -version` Does Not Show the Installed Version

If `java -version` does not display the expected JDK version, ensure that your `JAVA_HOME` and `PATH` variables are set correctly. Reopen your terminal or re-source your `.bashrc` file to make sure the changes are applied.

### Issue: Unable to Open `.bashrc`

If you have trouble opening the `.bashrc` file, make sure you are using the correct path and filename. It should be in your home directory (`~/.bashrc`). If you're using a different shell like `zsh`, you should modify `.zshrc` instead.

---

For further assistance, consult the community forums or the official [Adoptium documentation](https://adoptium.net/).
