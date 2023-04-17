
<#macro info_annotation metadata>
@Info(metadata = {
    <#list metadata as element>
        "${element}"<#sep>, <#t>
    </#list>

})
</#macro>

<#-- syntax of macro: macro-keyword macro-name param1 param2 etc -->
<#-- if param is null, loop will do nothing -->

<#-- '<#sep>' means separate each element by comma, check the following docu -->
<#-- https://freemarker.apache.org/docs/ref_directive_list.html#ref_list_sep -->

<#-- '<#t>' means trim whitespaces, check the following docu -->
<#-- https://freemarker.apache.org/docs/ref_directive_t.html -->