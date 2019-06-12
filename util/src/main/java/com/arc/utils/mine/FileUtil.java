package com.arc.utils.mine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 将inputStream中的文件写入filePath路径下的文件
     *
     * @param inputStream
     * @param filePath
     */
    public static void writeFile(InputStream inputStream, String filePath) throws IOException {
        writeFile(inputStream, new File(filePath));
    }

    /**
     * 将inputStream中的文件写入destFile
     *
     * @param inputStream
     * @param destFile
     */
    public static void writeFile(InputStream inputStream, File destFile) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
             BufferedInputStream bis = new BufferedInputStream(inputStream)) {
            int count, bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((count = bis.read(buffer, 0, bufferSize)) != -1) {
                bos.write(buffer, 0, count);
            }
        }
    }

    public static String extractFileName(String originalFileName) {
        if (StringUtils.isBlank(originalFileName) || !originalFileName.contains(".")) {
            return originalFileName;
        }
        return originalFileName.substring(0, originalFileName.lastIndexOf("."));
    }

    public static String extractFileSuffix(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
            return fileName;
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void extractDirAndCreate(String filePath) {
        String localFileDir = extractDir(filePath);
        //获取本地根目录
        File localDir = new File(localFileDir);
        if (!localDir.exists()) {
            if (!localDir.mkdirs()) {
                log.debug("根目录创建失败。localFileDir: " + localFileDir);
            }
        }
    }

    public static String extractDir(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return filePath;
        }
        //构建解压后保存的文件夹路径
        int index = filePath.lastIndexOf(File.separator);
        if (index != -1) {
            return filePath.substring(0, index);
        }
        return filePath;
    }

/*    public static SystemFile transferFile(MultipartFile file, String filePath) throws IOException {
        SystemFile convertFile = new SystemFile(filePath);
        if (convertFile.exists()) {
            if (!convertFile.delete()) {
                log.debug("本地文件已存在");
            }
        }
        FileUtil.extractDirAndCreate(filePath);
        try (InputStream inputStream = file.getInputStream()) {
            FileUtil.writeFile(inputStream, convertFile);
        }
        return convertFile;
    }*/

    public static String constructUniqueFileName(String originalFileName) {
        String uniqueFileName = FileUtil.extractFileName(originalFileName) + System.currentTimeMillis() + (int) (Math.random() * 10);
        return Md5Util.encrypt(uniqueFileName);
    }


    /**
     * 英文点号
     * The extension separator character.
     *
     * @since 1.4
     */
    public static final char EXTENSION_SEPARATOR = '.';

    /**
     * 下划线;
     */
    public static final char EXTENSION_UNDERLINE = '_';

    /**
     * 找不到，坐标溢出
     */
    private static final int NOT_FOUND = -1;

    /**
     * 正斜线
     * The Unix separator character.
     */
    private static final char UNIX_SEPARATOR = '/';

    /**
     * 反斜线
     * The Windows separator character.
     */
    private static final char WINDOWS_SEPARATOR = '\\';

    /**
     * 根据文件后缀判断文件是否是图片
     *
     * @param suffix
     * @return
     */
    public static boolean isImage(String suffix) {
        if ((suffix != null) && (suffix.length() > 0)) {
            //判断
            suffix = suffix.toLowerCase();
            switch (suffix) {
                case "jpg":
                case "jpeg":
                    return true;
                case "gif":
                    return true;
                case "png":
                    return true;
                case "bmp":
                    return true;
                case "pdf":
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    /**
     * @param filename     文件名称
     * @param targetString 需要输出的字符串
     */
    public void output(String filename, String targetString) {
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            fw.write(targetString, 0, targetString.length());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //=====================================================
    //                                          工具方法
    //=====================================================

    /**
     * @return 获取时间戳，精度到毫秒并拼接上随机数
     */
    public static String getSimpleCode() {
        StringBuffer stringBuffer = new StringBuffer();
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        int x = (int) (Math.random() * 900) + 1000;
        stringBuffer.append(time).append(x);
        return stringBuffer.toString();
    }


    /**
     * 获取现在时间字符串
     */
    public static String getDateString() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /**
     * @param sourceFileName 源文件名称
     * @return 唯一目标文件名称
     */
    public static String getTargetFileName(String sourceFileName) {
        //时间戳+uuid+sourceFileName
        return System.currentTimeMillis() + getUUID() + EXTENSION_UNDERLINE + sourceFileName;
    }

    /**
     * 获取uuid变体，去除了“-”
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * @param in  输入
     * @param out 输出
     * @return
     * @throws IOException
     */
    public static int copy(InputStream in, OutputStream out) throws IOException {
        Assert.notNull(in, "No InputStream specified");
        Assert.notNull(out, "No OutputStream specified");

        int byteCount = 0;
        byte[] buffer = new byte[4096];

        int bytesRead;
        for (boolean var4 = true; (bytesRead = in.read(buffer)) != -1; byteCount += bytesRead) {
            out.write(buffer, 0, bytesRead);
        }

        out.flush();
        return byteCount;
    }

    /**
     * 判断文件名称是否有异常
     *
     * @param filename 文件名称
     * @return
     */
    public static String getExtension(final String filename) {
        if (filename == null) {
            return null;
        }
        final int index = indexOfExtension(filename);
        if (index == NOT_FOUND) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }


    /**
     * 获取扩展名的index
     *
     * @param filename
     * @return
     */
    public static int indexOfExtension(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        final int lastSeparator = indexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? NOT_FOUND : extensionPos;
    }

    /**
     * 获取分隔符的index
     *
     * @param filename
     * @return
     */
    public static int indexOfLastSeparator(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        final int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }


    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取文件扩展名
     *
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 删除文件扩展名
     *
     * @param filename
     * @return
     */
    public static String deleteExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    public static String writeToDisk(InputStream inputStream, String outDir) {
        OutputStream outputStream = null;
        try {
            Assert.notNull(outDir, "No OutputStream specified");
            File outFile = new File(outDir);
            log.debug("结果outFile.exists={}", outFile.exists());
            if (!outFile.exists()) {
                boolean mkParentDirs = outFile.getParentFile().mkdirs();
                log.debug("父级文件夹{}，创建是否成功：{}", outFile.getParent(), mkParentDirs);
                boolean newFile = outFile.createNewFile();
                log.debug("文件写入文件夹{}，是否成功：{}", outFile.getParent(), newFile);
            }
            outputStream = new FileOutputStream(outFile);
            Assert.notNull(inputStream, "No InputStream specified");
            Assert.notNull(outFile, "No OutputStream specified");
            int byteCount = 0;
            byte[] buffer = new byte[4096];
            int bytesRead;
            for (boolean var4 = true; (bytesRead = inputStream.read(buffer)) != -1; byteCount += bytesRead) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(" OutputStream close出错", e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(" OutputStream close出错", e);
                }
            }
        }
        log.debug("文件保存在本地磁盘的位置为={}", outDir);
        return outDir;
    }


    private String getContentType(String realPath) {
        String extensionName = FileUtil.getExtensionName(realPath).toLowerCase();
        switch (extensionName) {
            case "jpg":
            case "jpeg":
                return "image/jpg";
            case "gif":
                return "image/gif";
            case "png":
                return "image/png";
            case "bmp":
                return "image/bmp";
            case "pdf":
                return "application/pdf";
            default:
                return "application/octet-stream";
        }
    }

    /**
     * 获取文件名称，支持中文，并自动过滤特殊字符
     * 注意：方法返回支持主流浏览器
     *
     * @param userAgent request.getHeader("User-Agent");
     * @param fileName
     * @return 编码过的文件名称
     * @throws Exception
     */
    //browser  UnsupportedEncodingException
    private static String getBrowserFileName(String userAgent, String fileName) throws Exception {

        if (fileName == null) {
            throw new NullPointerException("SystemFile name cannot be null!");
        }
        fileName = fileName.replaceAll("[^\u4e00-\u9fa5a-zA-Z0-9]", "");
        log.debug("编码前fileName {}", fileName);

//        String userAgent = request.getHeader("User-Agent");
        log.debug("请求头中的数据-UserAgent{} ", userAgent);
        //OPERA         UserAgent Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36 OPR/54.0.2952.64
        //CHROME    UserAgent Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36
        //IE11            UserAgent Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko
        // FF               UserAgent Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:44.0) Gecko/20100101 Firefox/44.0
        //        if (userAgent.indexOf("Chrome") > 0) { //WebKit 内核的浏览器 CHROME OPERA SAFARI
        //            fileName = URLEncoder.encode(fileName, "UTF-8");
        //        } else if (userAgent.toUpperCase().indexOf("MSIE") > 0  ) { //IE
        //            fileName = URLEncoder.encode(fileName, "UTF-8");
        //        } else
        if (userAgent.indexOf("Firefox") > 0) {//Firefox
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        } else {//未知
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        log.debug("编码后fileName {}", fileName);
        return fileName;
    }

}
