<#assign HIGHEST_SECTION_LEVEL = 3/>

<#macro writeOutputSection outputSection headerLevel>
    <#if outputSection.getTitle()??>
        <@writeTitle title=outputSection.getTitle() headerLevel=headerLevel/>
    </#if>
    <#if outputSection.getLines()??>
        <@writeLines lines=outputSection.getLines()/>
    </#if>
    <#if outputSection.getOutputSectionList()??>
        <#list outputSection.getOutputSectionList() as childSection>
            <#if childSection??>
                <@writeOutputSection outputSection=childSection headerLevel=headerLevel+1/>
            </#if>
        </#list>
    </#if>
</#macro>

<#macro writeTitle title headerLevel>
    <h${headerLevel}>${title}</h${headerLevel}>
</#macro>

<#macro writeLines lines>
    <#list lines as line>
        <p>${line}</p>
    </#list>
</#macro>

<#macro writeNavigation outputNavigationNode>
    <#assign name = outputNavigationNode.getName()/>
    <#assign resource = outputNavigationNode.getResource()/>
    <ul>
        <li><a href="${resource}">${name}</a></li>
        <#if outputNavigationNode.getOutputNavigationNodeList()??>
            <li>
                <#list outputNavigationNode.getOutputNavigationNodeList() as childOutputNavigationNode>
                    <@writeNavigation outputNavigationNode=childOutputNavigationNode/>
                </#list>
            </li>
        </#if>
    </ul>
</#macro>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Lonely Planet</title>
    <link href="static/all.css" media="screen" rel="stylesheet" type="text/css">
  </head>

  <body>
    <div id="container">
      <div id="header">
        <div id="logo"></div>
        <h1>Lonely Planet: ${destination.title}</h1>
      </div>

      <div id="wrapper">
        <div id="sidebar">
          <div class="block">
            <h3>Navigation</h3>
            <div class="content">
              <div class="inner">
                <#if destination.getNavigationTree()??>
                   <@writeNavigation outputNavigationNode=destination.getNavigationTree()/>
                </#if>
              </div>
            </div>
          </div>
        </div>

        <div id="main">
          <div class="block">
            <div class="content">
              <div class="inner">
                <#if destination.getIntroductionOutputSection()??>
                   <@writeOutputSection outputSection=destination.getIntroductionOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getHistoryOutputSection()??>
                   <@writeOutputSection outputSection=destination.getHistoryOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getPracticalInformationOutputSection()??>
                   <@writeOutputSection outputSection=destination.getPracticalInformationOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getTransportOutputSection()??>
                   <@writeOutputSection outputSection=destination.getTransportOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getWeatherOutputSection()??>
                   <@writeOutputSection outputSection=destination.getWeatherOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getWildLifeOutputSection()??>
                   <@writeOutputSection outputSection=destination.getWildLifeOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
                <#if destination.getWorkLiveStudyOutputSection()??>
                   <@writeOutputSection outputSection=destination.getWorkLiveStudyOutputSection() headerLevel=HIGHEST_SECTION_LEVEL/>
                </#if>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>