1.设置Eclipse的编码
  |-因为代码中夹杂了中文，在编码格式没有设置成UTF-8之前，中文都是乱码显示。
  |-那么接下来在Eclipse中如何设置相关的文本文件为UTF-8的编码呢？
    |-Window--preference--General--Workspace，点击进入到这个窗口下面之后，找到Text file encoding,选择other，UTF-8
    哈哈，很简单吧，不过这只是设置了第一个地方，接下来还有。
    |-Window--preference--General--Content Types--Text--java source file，在default encoding后面手动输入UTF-8，然后点击update。
    |-当然，在这个地方，还可以设置其他类型文件的编码格式，就不一一介绍了。方法都是相同的。
