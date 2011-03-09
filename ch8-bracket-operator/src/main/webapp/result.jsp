<html>
<body>
  <%-- hfsj p 376 --%>
  <h3>Music</h3>
  An example of Ambient is: ${requestScope.musicMap.Ambient} <br/>
  An example of Ambient is: ${musicMap.Ambient} <br/>                          <%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  An example of Ambient is: ${requestScope.musicMap["Ambient"]} <br/>          <%-- "Ambient" becomes a key into the musicMap --%>
  An example of Ambient is: ${musicMap["Ambient"]} <br/>                       <%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  An example of Ambient is: ${musicMap['Ambient']} <br/>                       <%-- works with single quotes as well as double quotes  --%>
  An example of Ambient is: ${requestScope.musicMap[requestScope.Genre]} <br/> <%-- Genre is defined as a request attribute, resolves to "Ambient" --%>
  An example of Ambient is: ${musicMap[Genre]}  <br/>                          <%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  An example of Ambient is: ${requestScope.musicMap[MusicType[0]]} <br/>       <%-- MusicType is an StringArray of the keys of the map --%>
  An example of Ambient is: ${requestScope.musicMap[MusicType["0"]]} <br/>     <%-- works with or w/o quotes - a String type is coerced into int --%>
  An example of Ambient is: ${requestScope.musicMap[MusicType['0']]}           <%-- works with single quotes as well as double quotes --%>
</body>
</html> 