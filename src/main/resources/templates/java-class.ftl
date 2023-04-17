
<#import "annotation.ftl" as annotion>

package ${package};

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
<#if info == true>
    <@annotion.info_annotation metadata! />
</#if>
public class ${name} {

    private int age;
    private String description;

}

<#-- 'package' param is available in all templates, check freemarker config -->
<#-- DataModel will be passed in with the following params: 'name', 'info' and 'metadata' -->

<#-- syntax of macro call: file-alias.macro-name param1 param2 etc -->
<#-- '!' means it can be null, check the following docu -->
<#-- https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_missing_default -->