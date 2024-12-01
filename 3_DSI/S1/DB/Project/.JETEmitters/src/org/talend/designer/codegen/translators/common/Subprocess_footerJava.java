package org.talend.designer.codegen.translators.common;

import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Iterator;
import java.util.Vector;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;

public class Subprocess_footerJava
{
  protected static String nl;
  public static synchronized Subprocess_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Subprocess_footerJava result = new Subprocess_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\tthis.status = \"failure\";" + NL + "\t\t\t\t\t\tInteger localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get(\"errorCode\"));" + NL + "\t\t\t\t\t\tif (localErrorCode != null) {" + NL + "\t\t\t\t\t\t\tif (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {" + NL + "\t\t\t\t\t\t\t\tthis.errorCode = localErrorCode;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t            pool.setErrorThread(this, new TalendException(e, currentComponent, globalMap));" + NL + "\t\t\t            //pool.setErrorThread(this,e);" + NL + "\t\t\t            pool.stopAllThreads();" + NL + "\t\t\t\t\t}finally{" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t}catch(java.lang.Exception e){\t" + NL + "\t\t\t\t\t\t\t//ignore" + NL + "\t\t\t\t\t\t}catch(java.lang.Error error){" + NL + "\t\t\t\t\t\t\t//ignore" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tresourceMap = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tthis.isRunning = false;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tInteger localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get(\"errorCode\"));" + NL + "\t\t\t\t\tString localStatus = (String) (((java.util.Map) threadLocal.get()).get(\"status\"));" + NL + "\t\t\t\t\tif (localErrorCode != null) {" + NL + "\t\t\t\t\t\tif (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {" + NL + "\t\t\t\t\t\t\tthis.errorCode = localErrorCode;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} " + NL + "\t\t\t\t\tif (!this.status.equals(\"failure\")) {" + NL + "\t\t\t\t\t\tthis.status = localStatus;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\t\tpool.getTalendThreadResult().setErrorCode(this.errorCode);" + NL + "\t\t\t\t\tpool.getTalendThreadResult().setStatus(this.status);\t" + NL + "\t\t\t\t}//Run method" + NL + "\t\t\t}//ParallelThread class" + NL + "" + NL + "\t\t\tList<String[]> buffer = (List<String[]>) globalMap" + NL + "\t\t\t\t\t.get(\"PARALLEL_FLOW_BUFFER_";
  protected final String TEXT_3 = "\");" + NL + "" + NL + "\t\t\tif (pool.isFull()) {" + NL + "\t\t\t\tParallelThread pt = pool.getFreeThread();// wait for Free Thread" + NL + "\t\t\t\tif (pt!= null) {" + NL + "\t\t\t\t\tpt.putBuffer(buffer);// notify the ParallelThread" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\t// Start a new thread" + NL + "\t\t\t\t";
  protected final String TEXT_4 = "_ParallelThread pt = new ";
  protected final String TEXT_5 = "_ParallelThread(" + NL + "\t\t\t\t\t\tglobalMap, (Object[]) globalMap" + NL + "\t\t\t\t\t\t\t\t.get(\"PARALLEL_FLOW_LOCK_";
  protected final String TEXT_6 = "\"));" + NL + "\t\t\t\tpt.putBuffer(buffer);" + NL + "\t\t\t\tpool.execThread(pt);" + NL + "\t\t\t}" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} catch (java.lang.Exception te) {" + NL + "\t\t\tthrow new TalendException(te, currentComponent, globalMap);" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\t\tglobalMap.put(\"COMPLETED_";
  protected final String TEXT_8 = "\",Boolean.TRUE);" + NL + "            class DepartitionerPoison_";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = "Struct {" + NL + "            }" + NL + "\t\t\tresourceMap.put(\"finish_";
  protected final String TEXT_11 = "\", true); " + NL + "" + NL + "\t\t\toutputQueue_";
  protected final String TEXT_12 = ".put(new DepartitionerPoison_";
  protected final String TEXT_13 = "());";
  protected final String TEXT_14 = NL + "            \tlog.info(\"";
  protected final String TEXT_15 = "[\" + Thread.currentThread().getName() + \"] - Done.\");";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t}//end the resume" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_19 = "Process(globalMap);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t    \t\t\tif(resumeEntryMethodName == null || globalResumeTicket){" + NL + "\t\t\t\t    \t\t\t\tresumeUtil.addLog(\"CHECKPOINT\", \"CONNECTION:";
  protected final String TEXT_21 = ":";
  protected final String TEXT_22 = "\", \"\", Thread.currentThread().getId() + \"\", \"\", \"\", \"\", \"\", \"\");" + NL + "\t\t\t\t\t\t\t\t}\t    \t\t\t\t    \t\t\t" + NL + "\t\t\t\t\t    \t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\t\tif(execStat){    \t" + NL + "\t\t\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_24 = "\", 0, \"ok\");" + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_25 = "Process(globalMap); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = NL + NL + NL + NL + "\t" + NL + "\t\t\t}catch(java.lang.Exception e){\t" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t    if(!(e instanceof TalendException)){" + NL + "\t\t\t\t\t   log.fatal(currentComponent + \" \" + e.getMessage(),e);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tTalendException te = new TalendException(e, currentComponent, globalMap);" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tte.setVirtualComponentName(currentVirtualComponent);" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_31 = "\") == null){" + NL + "\t\t\t\t\t\tif(resourceMap.get(\"start_";
  protected final String TEXT_32 = "\") != null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_34 = "[\" + Thread.currentThread().getName() + \"] - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\tglobalMap.put(\"THREADS_HAVE_ERROR\", e);" + NL + "\t\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tthrow te;" + NL + "\t\t\t}catch(java.lang.Error error){\t" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\trunStat.stopThreadStat();" + NL + "\t\t\t\t";
  protected final String TEXT_38 = "[\" + Thread.currentThread().getName() + \"] - \" + error.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\tglobalMap.put(\"THREADS_HAVE_ERROR\",error);" + NL + "\t\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\tthrow error;" + NL + "\t\t\t}finally{" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t//free memory for \"";
  protected final String TEXT_42 = "\"" + NL + "\t\t\t\t\t\t\tglobalMap.remove(\"";
  protected final String TEXT_43 = "\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t     \t\t\t//free memory for \"";
  protected final String TEXT_45 = "\"" + NL + "\t\t\t\t\t     \t\t\tglobalMap.remove(\"tHash_Lookup_";
  protected final String TEXT_46 = "\"); " + NL + "\t\t\t\t     \t\t\t";
  protected final String TEXT_47 = "      \t" + NL + "\t\t\t\t\t      \t\t\t//free memory for \"";
  protected final String TEXT_48 = "\"" + NL + "\t\t\t\t\t\t\t\t\tglobalMap.remove(\"tHash_";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t\t      \t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t}catch(java.lang.Exception e){\t" + NL + "\t\t\t\t\t//ignore" + NL + "\t\t\t\t}catch(java.lang.Error error){" + NL + "\t\t\t\t\t//ignore" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresourceMap = null;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_52 = NL + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_53 = "_SUBPROCESS_STATE\", 1);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_54 = NL + "\t\t/**" + NL + "\t\t * End of Function: ";
  protected final String TEXT_55 = "Process " + NL + "\t\t\t */" + NL + " \t\t";
  protected final String TEXT_56 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
    NodesSubTree subTree = (NodesSubTree) v.get(0);
    String finallyPart = v.get(1).toString();
	boolean stat = codeGenArgument.isStatistics();
	IProcess process = subTree.getRootNode().getProcess();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	for(INode node : subTree.getNodes()){
		List<IMetadataTable> metadatas = node.getMetadataList();
		List< ? extends IConnection> conns = node.getOutgoingConnections();
	}

	boolean isParallelize = false;
	for(INode node : subTree.getNodes()){
		if(node!=null){
			String parallelize = ElementParameterParser.getValue(node, "__PARALLELIZE__");
			if(parallelize!=null &&parallelize.equals("true")){
				// temporary modification : if tAsyncIn is available, this is always a parallelized process
				isParallelize = true;
			}
		}
	}
	
	List<INode> departitionersInCurrentSubTree = new java.util.ArrayList<INode>();
	INode startNode = subTree.getRootNode();
	String startNodeId = startNode.getUniqueName();
	
	if ("tCollector".equals( startNode.getComponent().getOriginalName() )) {
		List<? extends INode> departitioners = startNode.getProcess().getNodesOfType("tDepartitioner");
    	if(departitioners!=null) {
    		for(INode departitioner : departitioners) {
    			INode collectorNode = NodeUtil.getSubProcessStartNode(departitioner);
    			if(collectorNode == startNode) {//in current sub tree
    				departitionersInCurrentSubTree.add(departitioner);
    			}
    		}
    	}
	}
	
	if(isParallelize){
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(finallyPart);
    stringBuffer.append(TEXT_2);
    stringBuffer.append((subTree.getName()).replaceAll("tAsyncIn", "tAsyncOut"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(subTree.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(subTree.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append((subTree.getName()).replaceAll("tAsyncIn", "tAsyncOut"));
    stringBuffer.append(TEXT_6);
    
	}else{
    	for(INode departitioner : departitionersInCurrentSubTree) {
			String cid = departitioner.getUniqueName();
		    String connName = null;
            if (departitioner.getIncomingConnections().size() == 1) {
                IConnection conn = departitioner.getIncomingConnections().get(0);
                connName = conn.getName();
            }
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
    	}
	
    stringBuffer.append(TEXT_17);
    	
				if(subTree.getRootNode().getProcess().getNodesOfType("tFlowMeterCatcher").size() > 0 
				  && subTree.getRootNode().getProcess().getNodesOfType("tFlowMeter").size() > 0){
					List<INode> metterCatchers = (List<INode>)subTree.getRootNode().getProcess().getNodesOfType("tFlowMeterCatcher");
					List<INode> metters = (List<INode>)subTree.getRootNode().getProcess().getNodesOfType("tFlowMeter");
					List<INode> nodes = (List<INode>)subTree.getNodes();
					
					boolean hasMetterProcess = false;
					for(INode tmp : nodes){
						for(INode metter : metters){
							if(tmp.getUniqueName().equals(metter.getUniqueName())){
								hasMetterProcess = true;
								break;
							}
						}
						if(hasMetterProcess){
							break;
						}
					}
					if(hasMetterProcess){
						for(INode metterCatcher : metterCatchers){
						
    stringBuffer.append(TEXT_18);
    stringBuffer.append(metterCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_19);
          
						}
					}
				}
				
				//this part for "Resume Management"
				{
				    INode firstNode = subTree.getNode(subTree.getName());
				    
				    List<String> beforeSubProcesses = subTree.getBeforeSubProcesses();
				    
				    //System.out.println(firstNode.getUniqueName());
				    List<? extends IConnection> outConns = firstNode.getOutgoingConnections();
				    
				    //System.out.println(inConns.size());
				    for(IConnection conn : outConns){
				    
						//boolean activeResume = "true".equals(ElementParameterParser.getValue(conn, "__RESUMING_CHECKPOINT__"));
				    	boolean activeResume = true;
				    	
				    	//System.out.println("Test:" + ElementParameterParser.getValue(conn, "__RESUMING_CHECKPOINT__"));
				    	
				    	String uniqueNameTargetNode = conn.getTarget().getUniqueName();
				    	
				   		EConnectionType lineStyle = conn.getLineStyle();
				
						if(beforeSubProcesses.indexOf(uniqueNameTargetNode) != -1){   		
					    	if(activeResume){
					    	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(lineStyle.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(subTree.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(conn.getOutputId() > 0 ? conn.getOutputId() : "" );
    stringBuffer.append(TEXT_22);
    
					    	}
							if(stat){
							
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getUniqueName() );
    stringBuffer.append(TEXT_24);
    
							}
							
    stringBuffer.append(TEXT_18);
    stringBuffer.append( uniqueNameTargetNode );
    stringBuffer.append(TEXT_25);
    
				    	}
				    }
				}
				
    stringBuffer.append(TEXT_26);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_27);
    
				}
				
    stringBuffer.append(TEXT_28);
    
				if(NodeUtil.hasVirtualComponent(subTree.getNodes())){
				
    stringBuffer.append(TEXT_29);
    
				}
				
				for(INode departitioner : departitionersInCurrentSubTree) {
					String cid = departitioner.getUniqueName();
					
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    
				}
				
    stringBuffer.append(TEXT_36);
    
				if(stat){
				
    stringBuffer.append(TEXT_37);
    
				}
				
				for(INode departitioner : departitionersInCurrentSubTree) {
					String cid = departitioner.getUniqueName();
					
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
				}
				
    stringBuffer.append(TEXT_40);
    
				//generate the code to free memory for lookup link and virtual component buffered datas 
				List<INode> nodes = subTree.getNodes();
				for(INode node:nodes){
				
					boolean isVirtualGenerateNode = node.isVirtualGenerateNode();
					
					//check the virtual component generate node
					if(isVirtualGenerateNode){
						String origin  = ElementParameterParser.getValue(node, "__ORIGIN__");
						if(origin != null && !"".equals(origin)){
						
    stringBuffer.append(TEXT_41);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(origin);
    stringBuffer.append(TEXT_43);
    
						}
					}else{
					//check the Lookup link
						List<? extends IConnection> lookupInput = node.getIncomingConnections(EConnectionType.FLOW_REF);
						if(lookupInput!=null && lookupInput.size()>0){
							//check the tMap like this, instanceof can't work			
							if(node.getClass().getName().equals("org.talend.designer.mapper.MapperComponent")){
								for(IConnection connection:lookupInput){						
				     			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connection.getName());
    stringBuffer.append(TEXT_46);
    
				            	}
				            }else{
				            	for(IConnection connection:lookupInput){
				      			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection.getName());
    stringBuffer.append(TEXT_49);
          		 
								} 
							} 
						}
					}
				}
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(finallyPart);
    stringBuffer.append(TEXT_51);
    
		}//isParallelize
		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(subTree.getName() );
    stringBuffer.append(TEXT_53);
    
	if(subTree.isMethodSizeNeeded()){ 
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(subTree.getName() );
    stringBuffer.append(TEXT_55);
    
 		}
 		
    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}
