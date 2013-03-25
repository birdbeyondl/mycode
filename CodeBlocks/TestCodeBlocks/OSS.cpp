static void cleanup_oss_soundcore(void)
{
    /* 卸载该字符设备 */
    unregister_chrdev(SOUND_MAJOR,"sound");
}
    //初始化OSS模块
static int _init init_oss_soundcore(void)
{
    //注册该字符设备
    if(register_chrdev(SOUND_MAJOR,"sound",&soundcore_fops)==-1)
    {
        printk(KERN_ERR "soundcore:sound device already in use.\n");
        return _EBUZY;
    }
    return 0;
}
module_init(init_soundcore);
module_exit(cleanup_soundcore);


static int soundcore_open(struct inode *,struct file *);
static const struct file_operations soundcore_fops =
{
    .owner = THIS_MODULE,
    .open = soundcore_open,
};


//注册
extern int register_sound_special(const struct file_operations *fops,int unit);
extern int register_sound_special_device(const struct file_operations *fops,int unit,struct device *dev);
extern int register_sound_mixer(const struct file_operations *fops,int dev);
extern int register_sound_midi(const struct file_operations *fops,int dev);
extern int register_sound_dsp(const struct file_operations *fops,int dev);
//卸载
extern void unregister_sound_special(int unit);
extern void unregister_sound_mixer(int unit);
extern void unregister_sound_midi(int unit);
extern void unregister_sound_dsp(int unit);

