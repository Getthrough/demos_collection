package com.github.getthrough.jvm.class_loader;

import lombok.extern.slf4j.Slf4j;

/**
 * Java 虚拟机类加载器相关
 *
 * <p>
 * Java 中一个类是如何被加载到 JVM 中的呢？<br>
 * 简单来说，类的 .java 文件经过编译后生成 .class 文件，然后由类加载器找到 class 文件并将其装载到虚拟机内存中。
 * <pre>
 *     详细过程为：
 *
 *     加载 -> 连接（验证 -> 准备 -> 解析）-> 初始化 -> 使用 -> 卸载
 *
 *     1. 加载阶段，类加载器通过类的全限定名（或网络地址，压缩包等）获取类的二进制字节流，然后转化为方法区的运行时数据结构。从
 *     Jdk 1.8 开始，hotspot 虚拟机取消了永久代（原来它作为方法区的实现），换成了元数据空间（MetaSpace），相应地，
 *     类信息改为存在元数据空间中，然后由虚拟机在堆中生成一个代表这个类的 Class 对象，它作为类信息数据访问的入口。
 *     但是类的加载时机在虚拟机规范中没有强制约束，由虚拟机具体实现自己把握。
 *
 *     2. 验证阶段，将对字节流进行文件格式验证、元数据验证、字节码验证、符号引用验证。
 *
 *     3. 准备阶段，为类的静态变量赋值初始值。
 *
 *     4. 解析阶段，将常量池内的符号引用替换为直接引用。
 *
 *     5. 初始化阶段，该阶段分为类初始化和实例初始化。类初始化主要是执行类构造器 <clinit>() 方法的过程，clinit 方法中主要
 *     做了类静态字段和静态代码块的初始化；实例的初始化在合适的加载时机会进行，如使用 new, 读取/设置非 final 的静态字段，
 *     使用反射，指定的 main 方法所在类，反序列化等。
 *
 *     具体过程为：父类的类构造器<clinit>() -> 子类的类构造器<clinit>() -> 父类的成员变量和实例代码块 -> 父类的构造函数 ->
 *               子类的成员变量和实例代码块 -> 子类的构造函数
 * </pre>
 *
 * 为什么要自定义类加载器？
 *
 * 1. 用于加载不在 classPath 而在其他路径下的类
 * 2. 加载从网络中获取的类字节流
 * 3. 可以定义类的实现机制，实现类的热部署,如 OSGi 中的 bundle 模块就是通过实现自己的 ClassLoader 实现的
 *
 * </p>
 *
 * @author getthrough
 * @date 2020-02-06
 */
@Slf4j
public class JVMClassLoader extends ClassLoader {

    /**
     * 重写 findClass 方式是最合适的，如果重写 {@link ClassLoader#loadClass(String)} 容易破坏双亲委派机制
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 处理查找类文件逻辑

        // 如果查找不到，那么委托父加载器加载
        return super.findClass(name);
    }


}
