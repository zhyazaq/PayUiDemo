package digitalnet.com.dagger.demo4;

import dagger.Component;

/**
 * 北京润农金服科技有限公司  版权所有
 * Copyright (c) 2018 www.runnongjinfu.com All Rights Reserved
 * <p>
 * 作者：曾红永  Email：751086743@qq.com
 * 创建时间：2018/10/25 17:38  星期四
 * 类描述 ： This is  PersonComponent
 * </p>
 **/
@Component(modules = DataModule.class)
public interface PersonComponent {
      void inject(QualifierAcitivity qualifierAcitivity);
}
