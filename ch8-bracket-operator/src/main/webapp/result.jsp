<html>
<body>
  <%-- hfsj p 376 --%>
  <h3>Music</h3>
  An example of Ambient is: ${requestScope.musicMap.Ambient}
  <br/>
  An example of Ambient is: ${musicMap.Ambient}<%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  <br/>
  An example of Ambient is: ${requestScope.musicMap["Ambient"]}<%-- "Ambient" becomes a key into the musicMap --%>
  <br/>
  An example of Ambient is: ${musicMap["Ambient"]}<%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  <br/>
  An example of Ambient is: ${requestScope.musicMap[requestScope.Genre]}<%-- Genre is defined as a request attribute, resolves to "Ambient" --%>
  <br/>
  An example of Ambient is: ${musicMap[Genre]}<%-- works w/o using the implicit EL variable requestScope. requestScope is default --%>
  <br/>
  An example of Ambient is: ${requestScope.musicMap[MusicType[0]]}<%-- MusicType is an StringArray of the keys of the map --%>
  <br/>
  An example of Ambient is: ${requestScope.musicMap[MusicType["0"]]}<%-- works with or w/o quotes - a String type is coerced into int --%>
</body>
</html>