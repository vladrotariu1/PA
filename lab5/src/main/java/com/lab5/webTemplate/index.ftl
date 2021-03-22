<html>
    <head>
        <title>Web Template Example</title>
    </head>
    <body>
        <ul>
            <#list catalog.itemList as item>
                <source src="${item.path}">
            </#list>
        </ul>
    </body>
</html>