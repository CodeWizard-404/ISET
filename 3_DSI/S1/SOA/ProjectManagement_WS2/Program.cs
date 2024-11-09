using Microsoft.EntityFrameworkCore;
using ProjectManagement_WS2.Data;
using SoapCore;

var builder = WebApplication.CreateBuilder(args);

// Register DbContext with MySQL 
builder.Services.AddDbContext<ProjectManagementDbContext>(options => options.UseMySQL(builder.Configuration.GetConnectionString("ProjectManagementDbConnection")));

builder.Services.AddSoapCore(); builder.Services.AddScoped<ProjectService>();

builder.Services.AddEndpointsApiExplorer(); builder.Services.AddSwaggerGen();

var app = builder.Build();

app.UseSwagger(); app.UseSwaggerUI();

app.UseSoapEndpoint<ProjectService>("/ProjectManagement_WS2", new SoapEncoderOptions());

app.Run();

