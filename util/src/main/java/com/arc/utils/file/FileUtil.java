package com.arc.utils.file;

import com.arc.utils.mine.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 叶超
 * 2018/10/22 18:09
 */
public class FileUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    //=====================================================
    //                                          静态属性
    //=====================================================

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
     * 减号
     */
    public static final String MINUS_SIGN = "-";

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

    public static List<String> imageSuffixes = new ArrayList<>();
    public static List<String> soundSuffixes = new ArrayList<>();

    static {
        //Webp格式、BMP格式、PCX格式、TIF格式、GIF格式、JPEG格式、TGA格式、EXIF格式。
        imageSuffixes.add("BMP");
        imageSuffixes.add("PCX");
        imageSuffixes.add("TIF");
        imageSuffixes.add("GIF");
        imageSuffixes.add("JPEG");
        imageSuffixes.add("TGA");
        imageSuffixes.add("EXIF");

        //FPX格式、SVG格式、PSD格式、CDR格式、PCD格式、DXF格式、UFO格式、EPS格式。
        imageSuffixes.add("SVG");
        imageSuffixes.add("PSD");
        imageSuffixes.add("CDR");
        imageSuffixes.add("PCD");
        imageSuffixes.add("DXF");
        imageSuffixes.add("UFO");
        imageSuffixes.add("EPS");

        //AI格式、PNG格式、HDRI格式、RAW格式、WMF格式、FLIC格式、EMF格式、ICO格式。
        imageSuffixes.add("PNG");
        imageSuffixes.add("HDRI");
        imageSuffixes.add("RAW");
        imageSuffixes.add("WMF");
        imageSuffixes.add("FLIC");
        imageSuffixes.add("EMF");
        imageSuffixes.add("ICO");


        //https://en.wikipedia.org/wiki/Image_file_formats#Compound_formats_(see_also_Metafile)
        imageSuffixes.add("PDF");
        imageSuffixes.add("TIFF");
        imageSuffixes.add("DNG");

        //=====================

        //无损格式，例如WAV，FLAC，APE，ALAC，WavPack(WV)
        soundSuffixes.add("WAV");
        soundSuffixes.add("FLAC");
        soundSuffixes.add("APE");
        soundSuffixes.add("ALAC");
        soundSuffixes.add("WV");

        //有损格式，例如MP3，AAC，Ogg Vorbis，Opus
        soundSuffixes.add("MP3");
        soundSuffixes.add("AAC");
        soundSuffixes.add("OGG");

        //
        soundSuffixes.add("WMA");
        soundSuffixes.add("RM");
        soundSuffixes.add("M4A");
        soundSuffixes.add("DTS");
    }

    public static List<String> getImageSuffixes() {
        return imageSuffixes;
    }

    public static List<String> getSoundSuffixes() {
        return soundSuffixes;
    }

    //=====================================================
    //                                          工具方法
    //=====================================================

    /**
     * 获取分隔符的index
     *
     * @param filename
     * @return
     */
    public static int getIndexOfLastSeparator(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        final int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    /**
     * 获取扩展名的index
     *
     * @param filename
     * @return
     */
    public static int getIndexOfExtension(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        final int lastSeparator = getIndexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? NOT_FOUND : extensionPos;
    }

    /**
     * 获取文件扩展名/后缀
     *
     * @param filename 文件名称
     * @return
     */
    public static String getExtension(final String filename) {
        if (filename == null) {
            return null;
        }
        final int index = getIndexOfExtension(filename);
        if (index == NOT_FOUND) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }

    /**
     * 获取文件扩展名 /提取文件名后缀
     *
     * @param filename
     * @return
     */
    public static String getFileSuffix(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }


    /**
     * 提取文件名
     *
     * @param originalFileName
     * @return
     */
    public static String extractFileName(String originalFileName) {
        if (StringUtils.isBlank(originalFileName) || !originalFileName.contains(".")) {
            return originalFileName;
        }
        return originalFileName.substring(0, originalFileName.lastIndexOf("."));
    }


    /**
     * 判断路径是否存在，若不存在则创建
     *
     * @param object 文件或者 String
     */
    public static boolean extractDirAndCreate(Object object) {
        File directory = null;
        if (object == null) {
            throw new RuntimeException("文件或路径不合法,为" + object);
        }
        if (object instanceof File) {
            directory = (File) object;
        } else if (object instanceof String && object.toString().trim().length() != 0) {
            directory = new File(object.toString());
        } else {
            return false;

        }

        if (directory.isFile()) {
            File parent = directory.getParentFile();
            boolean mkdirs = parent.mkdirs();
            if (!mkdirs) {
                //创建目录
                log.error("根目录创建失败，parent: {}。", parent);
                return false;
            }
        }
        return true;
    }


//
//    public static String extractDir(String filePath) {
//        if (StringUtils.isBlank(filePath)) {
//            return filePath;
//        }
//        //构建解压后保存的文件夹路径
//        int index = filePath.lastIndexOf(File.separator);
//        if (index != -1) {
//            return filePath.substring(0, index);
//        }
//        return filePath;
//    }

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
                case "jfif":
                case "jpg":
                case "jpeg":
                case "gif":
                case "png":
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
     * 获取指定路径下文件对应的ContentType
     *
     * @param realPath
     * @return
     */
    public static String getContentType(final String realPath) {
        String extensionName = FileUtil.getFileSuffix(realPath).toLowerCase();
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

    /**
     * 获取现在时间字符串
     */
    public static String getDateString() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
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
     * 构建目标文件唯一名称，1
     *
     * @param sourceFileName 源文件名称
     * @return 唯一目标文件名称
     */
    public static String builtTargetFileName(String sourceFileName) {
        //时间戳+uuid+sourceFileName
        return System.currentTimeMillis() + getUUID() + EXTENSION_UNDERLINE + sourceFileName;
    }

    /**
     * 构建目标文件唯一名称，2
     *
     * @param originalFileName
     * @return
     */
    public static String constructUniqueFileName(String originalFileName) {
        String uniqueFileName = FileUtil.extractFileName(originalFileName) + System.currentTimeMillis() + (int) (Math.random() * 10);
        return Md5Util.encrypt(uniqueFileName);
    }


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

    /**
     *
     * @param name
     * @param var
     * @return
     */
    public static String appendStringToEndName(String name, String var) {
        int lastIndexOfPoint = name.lastIndexOf(".");
        String preName = name.substring(0, lastIndexOfPoint);
        String suffix = name.substring(lastIndexOfPoint);
        log.info("文件后缀suffix={}" + suffix);
        log.info("文件插入片段var={}" + var);
        log.info("文件主题名称preName={}" + preName);
        return preName + var + suffix;
    }

    /**
     * @param filename     文件名称
     * @param targetString 需要输出的字符串
     */
    public void write(String filename, String targetString) {
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            fw.write(targetString, 0, targetString.length());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                flag = FileUtil.deleteDirectory(files[i].getAbsolutePath());
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
     * 文件持久化到磁盘
     *
     * @param inputStream
     * @param outDir
     * @return
     */

    public static String writeToDisk(InputStream inputStream, String outDir) {
        if (outDir == null) {
            throw new RuntimeException("outDir  must be not null ");
        }
        if (inputStream == null) {
            throw new RuntimeException("inputStream  must be not null ");
        }
        OutputStream outputStream = null;
        try {
            File outFile = new File(outDir);
            log.debug("结果outFile.exists={}", outFile.exists());
            if (!outFile.exists()) {
                boolean mkParentDirs = outFile.getParentFile().mkdirs();
                log.debug("父级文件夹{}，创建是否成功：{}", outFile.getParent(), mkParentDirs);
                boolean newFile = outFile.createNewFile();
                log.debug("文件写入文件夹{}，是否成功：{}", outFile.getParent(), newFile);
            }
            if (outFile == null) {
                throw new RuntimeException("outFile must be not null ");
            }
            outputStream = new FileOutputStream(outFile);
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
//
//    /***
//     * 处理上传文件
//     *
//     * @param file
//     * @param basePath        存放文件的目录的绝对路径 servletContext.getRealPath("/upload")
//     * @return
//     */
//    public static String upload(MultipartFile file, String basePath) {
//        String orgFileName = file.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(orgFileName);
//        try {
//            File targetFile = new File(basePath, fileName);
//            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
//            //把文件同步到公共文件夹
//            File publicFile = new File("/", fileName);
//            FileUtils.writeByteArrayToFile(publicFile, file.getBytes());
//        } catch (IOException e) {
//            log.error("异常={}", e);
//        }
//        return fileName;
//    }

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


    /**
     * 获取指定目录下的全部文件
     *
     * @param object
     * @return
     */
    public static List<File> listFileByDir(Object object) {
        File directory = null;
        if (object instanceof File) {
            directory = (File) object;
        } else if (object instanceof String) {
            directory = new File(object.toString());
        } else {
            return Collections.emptyList();
        }
        List<File> files = new ArrayList<File>();

        // 是一个文件
        if (directory.isFile()) {
            //files.add(directory);            return files;
            directory = directory.getParentFile();
            log.info("父路径={}", directory.getPath());
        }
        //是一个目录
        if (directory.isDirectory()) {
            File[] tempFiles = directory.listFiles();
            for (File tempFile : tempFiles) {
                if (tempFile.isDirectory()) {
                    files.addAll(listFileByDir(tempFile));
                    continue;
                }
                files.add(tempFile);
            }
        } else {
            log.error("directory='{}'不是一个合法的路径", directory);
        }
        return files;
    }


    /**
     * 文件名称替换掉指定字符串
     *
     * @param file
     * @param map
     * @return
     */
    public static boolean replaceFilenameByMap(File file, Map<String, String> map) {
        String name = file.getName();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            name = name.replaceAll(entry.getKey(), entry.getValue());
            log.debug("名字中去除所有匹配到的字符串 {} 后为 {}", entry.getKey(), name);
        }

        //重命名
        file.renameTo(new File(file.getParent() + File.separator + name));
        return true;
    }

    /**
     * 去除第一个匹配到的字符串
     *
     * @param file
     * @param map
     * @return
     */
    public static boolean replaceFilenameStartWithStringByMap(File file, Map<String, String> map) {
        String name = file.getName();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (name.startsWith(entry.getKey())) {
                name = name.replaceFirst(entry.getKey(), entry.getValue());
                log.debug("名字中去除第一个匹配到的字符串 {} 后为 {}", entry.getKey(), name);
            }
        }
        //重命名
        file.renameTo(new File(file.getParent() + File.separator + name));
        return true;
    }

    /**
     * 测试main
     *
     * @param args 无用
     */
    public static void main(String[] args) {
        fun1();
    }

    private static void fun1() {
        System.out.println("24534612203910144".length());
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));//20190113 180709850

        System.out.println();
        String uuid = UUID.randomUUID().toString();
        String uuidReplace = uuid.replace("-", "");
        System.out.println(uuid);                      //c4bf200f-85bf-431c-b91a-1c4c8247f1d7
        System.out.println(uuidReplace);        //c4bf200f85bf431cb91a1c4c8247f1d7
        System.out.println();
        Object x = Math.random();
        System.out.println("random--> " + x);
        String file2 = "a/b/c/application.txt";
        System.out.println(getIndexOfLastSeparator("application.txt"));
        System.out.println(getIndexOfLastSeparator(file2));
        System.out.println();
        System.out.println(getExtension(file2));
    }


}
