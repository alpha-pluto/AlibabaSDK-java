# AlibabaSDK-java
阿里巴巴开放平台SDK. 接入授权店铺数据，对接企业内部管理系统的解决方案


获取授权链接

  @Test
	public void testGetPreAuthUrl() throws Exception {
		PreAuthAPIPlot plot = new PreAuthAPIPlot("******", "1688", "http://www.eastmall.vip/ali-pre-auth", "******");
		String url = plot.getAuthorizationUrl();
		System.out.println(url);
	}

用授权码换取令牌

	@Test
	public void testAccessTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "******";
		String redirectUrl = "http://www.eastmall.vip/ali-pre-auth";
		String preAuthCode = "2c823974-63c8-4e5c-b3d5-09a6bacd5057";
		AccessTokenExecutor executor = new AccessTokenExecutor(clientId, clientSecret, redirectUrl, preAuthCode);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}

刷新令牌

	@Test
	public void testRefreshTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "******";
		String refreshToken = "41227eb4-520e-48e0-a432-7d17c870bf6c";
		RefreshTokenExecutor executor = new RefreshTokenExecutor(clientId, clientSecret, refreshToken);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}

更新令牌，通常如果refresh_token到期前一个月才允许更新令牌

	@Test
	public void testRenewRefreshTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "*******";
		String accessToken = "8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46";
		String refreshToken = "41227eb4-520e-48e0-a432-7d17c870bf6c";

		RenewRefreshTokenExecutor executor = new RenewRefreshTokenExecutor(clientId, clientSecret, accessToken,
				refreshToken);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}
  
  取得订单列表（卖家视图）
    
  @Test
	public void testOrderListOnSellerViewExecutor() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46");
		token.setAliId(123456789l);
		token.setMemberId("******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderListOnSellerView param = new ParamsOfOrderListOnSellerView();
		param.setPage(1);
		param.setPageSize(20);

		// 如果失败，是否再试一次
		boolean retryIfFail = true;

		OrderListOnSellerViewExecutor executor = new OrderListOnSellerViewExecutor(token, param, retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = executor.invoke();

		System.out.println(result);

	}

取得订单详情（卖家视图）

	@Test
	public void testOrderOnSellerViewExecutor() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46");
		token.setAliId(1234546789l);
		token.setMemberId("*******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderDetailOnSellerView param = new ParamsOfOrderDetailOnSellerView();
		param.setOrderId("159310337253103128");

		// 如果失败，是否再试一次
		boolean retryIfFail = true;

		OrderDetailOnSellerViewExecutor executor = new OrderDetailOnSellerViewExecutor(token, param, retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerViewResult> result = executor.invoke();

		System.out.println(result);
	}
